import React, { useEffect, useState } from "react";
import Layout from "../../components/Layout";
import api from "../../config/api";
import { BarChart, Bar, PieChart, Pie, Cell, XAxis, YAxis, Tooltip, Legend, ResponsiveContainer } from "recharts";

export default function Analytics() {
  const [analytics, setAnalytics] = useState(null);
  const [loading, setLoading] = useState(false);
  const COLORS = ["#0088FE", "#00C49F", "#FFBB28", "#FF8042", "#d63384"];

  const groupVisitors = (list) => {
    const map = {};
    list.forEach((item) => (map[item.eventName] = (map[item.eventName] || 0) + item.visitors));
    return Object.keys(map).map((name) => ({ eventName: name, visitors: map[name] }));
  };

  const groupScans = (list) => {
    const map = {};
    list.forEach((item) => (map[item.stallName] = (map[item.stallName] || 0) + item.scans));
    return Object.keys(map).map((name) => ({ stallName: name, scans: map[name] }));
  };

  const groupRatings = (list) => {
    const map = {}, count = {};
    list.forEach((item) => {
      map[item.stallName] = (map[item.stallName] || 0) + item.rating;
      count[item.stallName] = (count[item.stallName] || 0) + 1;
    });
    return Object.keys(map).map((name) => ({ stallName: name, rating: +(map[name] / count[name]).toFixed(1) }));
  };

  const loadData = async () => {
    setLoading(true);
    try {
      const res = await api.get("/admin/analytics");
      const data = res.data;
      setAnalytics({
        ...data,
        visitorsPerEvent: groupVisitors(data.visitorsPerEvent),
        scansPerStall: groupScans(data.scansPerStall),
        averageRatings: groupRatings(data.averageRatings),
      });
    } catch (err) {
      console.error(err);
      alert("Unable to load analytics");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => { loadData(); }, []);

  if (loading || !analytics) return (
    <Layout>
      <div className="d-flex justify-content-center align-items-center p-5">
        <div className="spinner-border text-primary" role="status">
          <span className="visually-hidden">Loading...</span>
        </div>
      </div>
    </Layout>
  );

  return (
    <Layout title="Admin Analytics">
      <div className="container py-4">
        <h2 className="text-white fw-bold mb-4">📊 System Analytics</h2>

        <div className="row g-4 mb-4">
          {[
            { label: "Total Events", value: analytics.totalEvents, color: "text-primary" },
            { label: "Total Stalls", value: analytics.totalStalls, color: "text-success" },
            { label: "Total Visitors", value: analytics.totalVisitors, color: "text-warning" },
            { label: "Total QR Scans", value: analytics.totalScans, color: "text-danger" },
          ].map((card) => (
            <div className="col-md-3" key={card.label}>
              <div className="card p-3 shadow text-center">
                <h5>{card.label}</h5>
                <h2 className={`${card.color} fw-bold`}>{card.value}</h2>
              </div>
            </div>
          ))}
        </div>

        <ChartCard title="Visitors Per Event">
          <BarChart data={analytics.visitorsPerEvent}>
            <XAxis dataKey="eventName" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Bar dataKey="visitors" fill="#0088FE" />
          </BarChart>
        </ChartCard>

        <ChartCard title="QR Scans Per Stall">
          <PieChart>
            <Pie data={analytics.scansPerStall} dataKey="scans" nameKey="stallName" outerRadius={120} label>
              {analytics.scansPerStall.map((entry, index) => (
                <Cell key={index} fill={COLORS[index % COLORS.length]} />
              ))}
            </Pie>
            <Tooltip />
            <Legend />
          </PieChart>
        </ChartCard>

        <ChartCard title="Average Stall Ratings">
          <BarChart data={analytics.averageRatings}>
            <XAxis dataKey="stallName" />
            <YAxis />
            <Tooltip />
            <Legend />
            <Bar dataKey="rating" fill="#d63384" label={({ value }) => value} />
          </BarChart>
        </ChartCard>
      </div>
    </Layout>
  );
}

const ChartCard = ({ title, children }) => (
  <div className="card p-4 shadow mb-4">
    <h5 className="fw-bold mb-3">{title}</h5>
    <ResponsiveContainer width="100%" height={300}>{children}</ResponsiveContainer>
  </div>
);
