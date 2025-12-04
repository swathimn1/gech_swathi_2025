import React, { useState } from "react";
import axios from "../api/axios";
import { toast } from "react-toastify";

export default function FeedbackForm({ stallId, eventId, onSubmitted }) {
  const [rating, setRating] = useState(5);
  const [comment, setComment] = useState("");
  const [loading, setLoading] = useState(false);

  const submit = async (e) => {
    e.preventDefault();
    setLoading(true);
    try {
      await axios.post(`/stalls/${stallId}/feedback`, {
        eventId,
        rating,
        comment,
      });
      toast.success("Feedback submitted");
      setComment("");
      setRating(5);
      if (onSubmitted) onSubmitted();
    } catch (err) {
      toast.error(err?.response?.data?.message || "Failed to submit feedback");
    } finally {
      setLoading(false);
    }
  };

  return (
    <form className="bg-white p-4 rounded shadow mt-4" onSubmit={submit}>
      <h4 className="font-semibold">Leave Feedback</h4>
      <div className="mt-2">
        <label className="text-sm">Rating</label>
        <select
          value={rating}
          onChange={(e) => setRating(Number(e.target.value))}
          className="border mt-1 p-2 w-full"
        >
          {[5,4,3,2,1].map((r) => <option key={r} value={r}>{r} star{r>1?'s':''}</option>)}
        </select>
      </div>
      <div className="mt-2">
        <label className="text-sm">Comment</label>
        <textarea
          value={comment}
          onChange={(e) => setComment(e.target.value)}
          rows={3}
          className="border mt-1 p-2 w-full"
        />
      </div>
      <button disabled={loading} className="mt-3 bg-sky-600 text-white px-4 py-2 rounded">
        {loading ? "Submitting..." : "Submit Feedback"}
      </button>
    </form>
  );
}
