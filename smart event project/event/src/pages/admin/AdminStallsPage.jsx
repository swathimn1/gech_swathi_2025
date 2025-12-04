import { useEffect, useState } from "react";
import { adminStallService } from "../../services/adminStallService";
import { useToast } from "../../hooks/use-toast";

const AdminStallsPage = () => {
  const { toast } = useToast();
  const [stalls, setStalls] = useState([]);
  const [form, setForm] = useState({
    name: "",
    category: "",
    ownerId: "",
    eventId: "",
    description: "",
  });
  const [editingId, setEditingId] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    loadStalls();
  }, []);

  const resetForm = () => {
    setForm({ name: "", category: "", ownerId: "", eventId: "", description: "" });
    setEditingId(null);
  };

  const loadStalls = async () => {
    setLoading(true);
    try {
      const res = await adminStallService.getAll();
      setStalls(Array.isArray(res.data) ? res.data : []);
    } catch (error) {
      console.error("Error loading stalls:", error);
      toast({
        variant: "destructive",
        title: "Error",
        description: "Failed to load stalls",
      });
      setStalls([]);
    } finally {
      setLoading(false);
    }
  };

  const handleChange = (e) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // ✅ Validate required IDs
      if (!form.eventId || !form.ownerId) {
        toast({
          variant: "destructive",
          title: "Missing Fields",
          description: "Please provide both Event ID and Owner ID",
        });
        return;
      }

      if (editingId) {
        await adminStallService.update(editingId, form);
        toast({ title: "Stall updated successfully" });
      } else {
        await adminStallService.create(form);
        toast({ title: "Stall created successfully" });
      }

      resetForm();
      loadStalls();
    } catch (error) {
      console.error("Error saving stall:", error);
      toast({
        variant: "destructive",
        title: "Error",
        description: error.response?.data || "Failed to save stall",
      });
    }
  };

  const handleEdit = (stall) => {
    setForm({
      name: stall.name,
      category: stall.category,
      ownerId: stall.ownerId,
      eventId: stall.eventId,
      description: stall.description,
    });
    setEditingId(stall.id);
  };

  const handleDelete = async (id) => {
    if (!window.confirm("Are you sure you want to delete this stall?")) return;
    try {
      await adminStallService.delete(id);
      toast({ title: "Stall deleted successfully" });
      loadStalls();
    } catch (error) {
      console.error("Error deleting stall:", error);
      toast({
        variant: "destructive",
        title: "Error",
        description: "Failed to delete stall",
      });
    }
  };

  return (
    <div className="container py-5">
      <h2 className="fw-bold mb-4 text-primary">🛍️ Manage Stalls</h2>

      {/* Stall Form */}
      <div className="card shadow-sm mb-5">
        <div className="card-header bg-light fw-semibold">
          {editingId ? "Edit Stall" : "Create New Stall"}
        </div>
        <div className="card-body">
          <form onSubmit={handleSubmit}>
            <div className="row g-3">
              <div className="col-md-6">
                <input
                  name="name"
                  value={form.name}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Stall Name"
                  required
                />
              </div>
              <div className="col-md-6">
                <input
                  name="category"
                  value={form.category}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Category"
                  required
                />
              </div>
              <div className="col-md-6">
                <input
                  name="ownerId"
                  value={form.ownerId}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Owner ID"
                  required
                />
              </div>
              <div className="col-md-6">
                <input
                  name="eventId"
                  value={form.eventId}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Event ID"
                  required
                />
              </div>
              <div className="col-12">
                <textarea
                  name="description"
                  value={form.description}
                  onChange={handleChange}
                  className="form-control"
                  placeholder="Stall Description"
                  rows={3}
                  required
                />
              </div>
              <div className="col-12 d-flex gap-2">
                <button type="submit" className="btn btn-primary">
                  {editingId ? "Update Stall" : "Create Stall"}
                </button>
                {editingId && (
                  <button
                    type="button"
                    className="btn btn-secondary"
                    onClick={resetForm}
                  >
                    Cancel
                  </button>
                )}
              </div>
            </div>
          </form>
        </div>
      </div>

      {/* Stall List */}
      <div className="card shadow-sm">
        <div className="card-header bg-light fw-semibold">All Stalls</div>
        <div className="card-body p-0">
          {loading ? (
            <div className="p-4 text-muted">Loading stalls...</div>
          ) : (
            <table className="table table-hover mb-0">
              <thead className="table-light">
                <tr>
                  <th>Name</th>
                  <th>Category</th>
                  <th>Owner ID</th>
                  <th>Event ID</th>
                  <th>Description</th>
                  <th style={{ width: "180px" }}>Actions</th>
                </tr>
              </thead>
              <tbody>
                {stalls.map((stall) => (
                  <tr key={stall.id}>
                    <td>{stall.name}</td>
                    <td>{stall.category}</td>
                    <td>{stall.ownerId}</td>
                    <td>{stall.eventId}</td>
                    <td>{stall.description}</td>
                    <td>
                      <button
                        title="Edit Stall"
                        className="btn btn-sm btn-warning me-2"
                        onClick={() => handleEdit(stall)}
                      >
                        Edit
                      </button>
                      <button
                        title="Delete Stall"
                        className="btn btn-sm btn-danger"
                        onClick={() => handleDelete(stall.id)}
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))}
                {stalls.length === 0 && (
                  <tr>
                    <td colSpan="6" className="text-center text-muted py-3">
                      No stalls found.
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          )}
        </div>
      </div>
    </div>
  );
};

export default AdminStallsPage;
