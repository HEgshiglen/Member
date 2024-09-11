import React, { useEffect, useState } from 'react';

function App() {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    // Fetch data from the API endpoint
    fetch('http://localhost:8080/api/members')
    // fetch('http://localhost:8080/api/sheet/data')
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(data => {
        setData(data);
        setLoading(false);
      })
      .catch(error => {
        setError(error);
        setLoading(false);
      });
  }, []); // Empty dependency array means this runs once when the component mounts

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error.message}</p>;

  return (
    <div>
      <h1>Member Data</h1>
      <table border="1">
        <thead>
          <tr>
            <th>Member</th>
            <th>Sep.24</th>
            <th>Oct.24</th>
            <th>Nov.24</th>
            <th>Dec.24</th>
            <th>Jan.25</th>
            <th>Feb.25</th>
            <th>Mar.25</th>
          </tr>
        </thead>
        <tbody>
          {data.map((item, index) => (
            <tr key={index}>
              <td>{item.member}</td>
              <td>{item["Sep.24"]}</td>
              <td>{item["Oct.24"]}</td>
              <td>{item["Nov.24"]}</td>
              <td>{item["Dec.24"]}</td>
              <td>{item["Jan.25"]}</td>
              <td>{item["Feb.25"]}</td>
              <td>{item["Mar.25"]}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default App;
