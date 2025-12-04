import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { visitorService } from "../services/visitorService";
import { useToast } from "../hooks/use-toast";
import Layout from "../components/Layout";
import { Calendar, MapPin, ArrowLeft, Info } from "lucide-react";

const EventDetail = () => {
  const { id } = useParams();
  const navigate = useNavigate();
  const { toast } = useToast();
  const [event, setEvent] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchEvent = async () => {
      try {
        setLoading(true);
        // Now fetches from /api/events/{id}
        const data = await visitorService.getEventById(id);
        console.log("Event Detail:", data);
        setEvent(data);
      } catch (error) {
        console.error("Error fetching event:", error);
        toast({
          title: "Error",
          description: "Failed to load event details",
          variant: "destructive",
        });
      } finally {
        setLoading(false);
      }
    };

    if (id) {
      fetchEvent();
    }
  }, [id, toast]);

  const formatDate = (input) => {
    if (!input) return "—";
    try {
      const date = new Date(input);
      return date.toLocaleDateString("en-IN", {
        day: "numeric",
        month: "long",
        year: "numeric",
      });
    } catch {
      return "—";
    }
  };

  if (loading) {
    return (
      <Layout title="Event Details">
        <div className="text-center py-5">
          <div className="spinner-border text-light" role="status">
            <span className="visually-hidden">Loading...</span>
          </div>
          <p className="text-light mt-3">Loading event details...</p>
        </div>
      </Layout>
    );
  }

  if (!event) {
    return (
      <Layout title="Event Not Found">
        <div className="text-center py-5">
          <div
            className="card mx-auto shadow-lg border-0"
            style={{
              maxWidth: "500px",
              background: "rgba(255,255,255,0.92)",
              borderRadius: "20px",
            }}
          >
            <div className="card-body p-5">
              <Info size={60} className="text-muted mb-3" />
              <h3 className="fw-bold text-dark mb-3">Event Not Found</h3>
              <p className="text-muted">
                The event you're looking for doesn't exist or has been removed.
              </p>
              <button
                className="btn btn-primary mt-3 px-4"
                onClick={() => navigate("/visitor/dashboard")}
              >
                <ArrowLeft size={18} className="me-2" />
                Back to Dashboard
              </button>
            </div>
          </div>
        </div>
      </Layout>
    );
  }

  return (
    <Layout title={`${event.title || "Event Details"} | Smart Event System`}>
      {/* Back Button */}
      <button
        className="btn btn-light mb-4 shadow-sm"
        onClick={() => navigate("/visitor/dashboard")}
        style={{ borderRadius: "10px" }}
      >
        <ArrowLeft size={18} className="me-2" />
        Back to Dashboard
      </button>

      {/* Event Detail Card */}
      <div
        className="card border-0 shadow-lg"
        style={{
          background: "rgba(255,255,255,0.95)",
          borderRadius: "25px",
        }}
      >
        <div className="card-body p-5">
          {/* Event Title (changed from name to title) */}
          <h1 className="fw-bold text-primary mb-4">
            {event.title || "Untitled Event"}
          </h1>

          {/* Event Dates */}
          <div className="d-flex align-items-center mb-3">
            <Calendar size={24} className="me-3 text-primary" />
            <div>
              <h6 className="fw-semibold mb-0 text-dark">Event Duration</h6>
              <p className="text-muted mb-0">
                {formatDate(event.startDate)} — {formatDate(event.endDate)}
              </p>
            </div>
          </div>

          {/* Location */}
          {event.location && (
            <div className="d-flex align-items-center mb-3">
              <MapPin size={24} className="me-3 text-success" />
              <div>
                <h6 className="fw-semibold mb-0 text-dark">Location</h6>
                <p className="text-muted mb-0">{event.location}</p>
              </div>
            </div>
          )}

          {/* Description */}
          {event.description && (
            <div className="mt-4 pt-4 border-top">
              <h5 className="fw-bold text-dark mb-3">About This Event</h5>
              <p className="text-muted" style={{ lineHeight: "1.8" }}>
                {event.description}
              </p>
            </div>
          )}

          {/* Stalls Section (if available) */}
          {event.stalls && event.stalls.length > 0 && (
            <div className="mt-4 pt-4 border-top">
              <h5 className="fw-bold text-dark mb-3">
                Participating Stalls ({event.stalls.length})
              </h5>
              <div className="row g-3">
                {event.stalls.map((stall) => (
                  <div className="col-md-6" key={stall.id}>
                    <div className="card border shadow-sm">
                      <div className="card-body">
                        <h6 className="fw-semibold text-primary">
                          {stall.name}
                        </h6>
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            </div>
          )}

          {/* Additional Actions */}
          <div className="mt-5 pt-4 border-top">
            <div className="d-flex gap-3 flex-wrap">
              <button
                className="btn btn-primary px-4"
                onClick={() => navigate("/visitor/events")}
                style={{ borderRadius: "10px" }}
              >
                Browse All Events
              </button>
              <button
                className="btn btn-outline-primary px-4"
                onClick={() => navigate("/visitor/scan")}
                style={{ borderRadius: "10px" }}
              >
                Scan QR Code
              </button>
            </div>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default EventDetail;