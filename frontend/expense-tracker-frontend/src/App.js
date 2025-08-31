import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [expenses, setExpenses] = useState([]);
  const [summary, setSummary] = useState([]);
  const [form, setForm] = useState({
    description: "",
    amount: "",
    category: "",
  });

  const API_BASE = "http://localhost:8080";

  useEffect(() => {
    fetchExpenses();
    fetchSummary();
  }, []);

  const fetchExpenses = async () => {
    const res = await axios.get(`${API_BASE}/expenses`);
    setExpenses(res.data);
  };

  const fetchSummary = async () => {
    const res = await axios.get(`${API_BASE}/expenses/summary`);
    setSummary(res.data);
  };

  const addExpense = async (e) => {
    e.preventDefault();
    if (!form.description || !form.amount || !form.category) {
      alert("Please fill all fields");
      return;
    }
    await axios.post(`${API_BASE}/expenses`, form);
    setForm({ description: "", amount: "", category: "" });
    fetchExpenses();
    fetchSummary();
  };

  const deleteExpense = async (id) => {
    await axios.delete(`${API_BASE}/expenses/${id}`);
    fetchExpenses();
    fetchSummary();
  };

  return (
    <div
      style={{
        padding: "20px",
        fontFamily: "Arial, sans-serif",
        backgroundColor: "#0F0616",
        minHeight: "100vh",
        color: "#fff",
      }}
    >
      <h1 style={{ textAlign: "center" }}>Expense Tracker</h1>

      {/* Add Expense Form */}
      <form
        onSubmit={addExpense}
        style={{ display: "flex", gap: "10px", marginBottom: "20px" }}
      >
        <input
          type="text"
          placeholder="Description"
          value={form.description}
          onChange={(e) => setForm({ ...form, description: e.target.value })}
          style={{ flex: 1, padding: "10px", borderRadius: "8px" }}
        />
        <input
          type="number"
          placeholder="Amount"
          value={form.amount}
          onChange={(e) => setForm({ ...form, amount: e.target.value })}
          style={{ width: "120px", padding: "10px", borderRadius: "8px" }}
        />
        <input
          type="text"
          placeholder="Category"
          value={form.category}
          onChange={(e) => setForm({ ...form, category: e.target.value })}
          style={{ width: "150px", padding: "10px", borderRadius: "8px" }}
        />
        <button
          type="submit"
          style={{
            padding: "10px 20px",
            borderRadius: "8px",
            backgroundColor: "#4CAF50",
            color: "#fff",
            border: "none",
          }}
        >
          Add
        </button>
      </form>

      {/* Expense List */}
      <table
        style={{
          width: "100%",
          borderCollapse: "collapse",
          backgroundColor: "#F8F4FF",
          color: "#000",
        }}
      >
        <thead>
          <tr>
            <th style={{ border: "1px solid #ddd", padding: "8px" }}>
              Description
            </th>
            <th style={{ border: "1px solid #ddd", padding: "8px" }}>Amount</th>
            <th style={{ border: "1px solid #ddd", padding: "8px" }}>
              Category
            </th>
            <th style={{ border: "1px solid #ddd", padding: "8px" }}>
              Actions
            </th>
          </tr>
        </thead>
        <tbody>
          {expenses.map((e) => (
            <tr key={e.id}>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>
                {e.description}
              </td>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>
                {e.amount}
              </td>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>
                {e.category}
              </td>
              <td style={{ border: "1px solid #ddd", padding: "8px" }}>
                <button
                  onClick={() => deleteExpense(e.id)}
                  style={{
                    backgroundColor: "#E53935",
                    color: "#fff",
                    border: "none",
                    padding: "5px 10px",
                    borderRadius: "6px",
                  }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      {/* Summary Section */}
      <h2 style={{ marginTop: "30px" }}>Summary</h2>
      <ul>
        {summary.map((s, index) => (
          <li key={index}>
            <strong>{s.category}</strong>: {s.totalAmount}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
