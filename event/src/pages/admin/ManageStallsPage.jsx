import React, { useEffect, useState } from "react";
import { adminService } from "../../services/adminService";

export default function ManageStallsPage() {
  const [stalls, setStalls] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => { load(); }, []);

  const load = async () => {
    setLoading(true);
    try {
      const res = await adminService.getAllStalls();
      setStalls(res.data || []);
    } catch (err) {
      console.error(err);
    } finally { setLoading(false); }
  };

  const approve = async (id) => {
    try {
      await adminService.approveStall(id);
      load();
    } catch (err) { console.error(err); }
  };

  const remove = async (id) => {
    if (!window.confirm("Delete stall?")) return;
    await adminService.deleteStall(id);
    load();
  };

  return (
    <div className="container py-4">
      <h3 className="text-white">Manage Stalls</h3>
      <div className="card p-3">
        {loading ? <div>Loading...</div> : (
          <table className="table">
            <thead><tr><th>#</th><th>Name</th><th>Owner</th><th>Event</th><th>Approved</th><th>Actions</th></tr></thead>
            <tbody>
              {stalls.map((s,i) => (
                <tr key={s.id}>
                  <td>{i+1}</td>
                  <td>{s.name}</td>
                  <td>{s.ownerName}</td>
                  <td>{s.eventTitle || "-"}</td>
                  <td>{s.approved ? "Yes" : "No"}</td>
                  <td>
                    {!s.approved && <button className="btn btn-sm btn-success me-2" onClick={() => approve(s.id)}>Approve</button>}
                    <button className="btn btn-sm btn-danger" onClick={() => remove(s.id)}>Delete</button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        )}
      </div>
    </div>
  );
}
