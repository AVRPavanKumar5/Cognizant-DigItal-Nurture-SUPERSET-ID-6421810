import React, { useState } from 'react';

function GuestPage() {
  return (
    <div>
      <h2>Guest Page</h2>
      <p>Browse flight details here.</p>
      {/* Example flight details */}
      <ul>
        <li>Flight 101: Mumbai to Delhi</li>
        <li>Flight 102: Delhi to Bangalore</li>
      </ul>
    </div>
  );
}

function UserPage() {
  return (
    <div>
      <h2>User Page</h2>
      <p>Book tickets here.</p>
      {/* Booking form placeholder */}
      <button>Book Flight 101</button>
    </div>
  );
}

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  return (
    <div>
      <h1>Ticket Booking App</h1>
      {isLoggedIn ? (
        <>
          <UserPage />
          <button onClick={() => setIsLoggedIn(false)}>Logout</button>
        </>
      ) : (
        <>
          <GuestPage />
          <button onClick={() => setIsLoggedIn(true)}>Login</button>
        </>
      )}
    </div>
  );
}

export default App;