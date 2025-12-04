import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import { Users } from "lucide-react";

const UsersPage = () => {
  const [users, setUsers] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/auth/users")
      .then((res) => setUsers(res.data))
      .catch((err) => console.error("Error fetching users:", err));
  }, []);

  return (
    <div
      className="min-vh-100 d-flex flex-column align-items-center justify-content-center"
      style={{
        background: "linear-gradient(135deg, #ff7e5f, #ff0844)",
        color: "white",
      }}
    >
      <div className="container text-center p-5">
        <h2 className="fw-bold">
          <Users size={30} className="me-2" />
          Registered Users
        </h2>

        {users.length > 0 ? (
          <table className="table table-striped mt-4 bg-white text-dark rounded shadow">
            <thead>
              <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
              </tr>
            </thead>
            <tbody>
              {users.map((user) => (
                <tr key={user.id}>
                  <td>{user.id}</td>
                  <td>{user.username}</td>
                  <td>{user.email}</td>
                  <td>{user.role}</td>
                </tr>
              ))}
            </tbody>
          </table>
        ) : (
          <p className="mt-4 fs-5">No registered users found.</p>
        )}

        <Link
          to="/"
          className="btn btn-light mt-4 px-4 rounded-pill shadow-sm"
        >
          ← Back to Home
        </Link>
      </div>
    </div>
  );
};

export default UsersPage;
