import React from 'react';

function App() {
  const office = {
    name: 'Prime Office Space',
    rent: 55000,
    address: '123 Main Street, Cityville'
  };

  const offices = [
    { name: 'Office A', rent: 50000, address: '456 Elm Street' },
    { name: 'Office B', rent: 70000, address: '789 Oak Avenue' },
    { name: 'Office C', rent: 65000, address: '101 Pine Road' }
  ];

  return (
    <div>
      <h1>Office Space Rental App</h1>
      <img src="https://via.placeholder.com/300?text=Office+Image" alt="Office Space" width="300" />
      <div>
        <p>Name: {office.name}</p>
        <p style={{ color: office.rent < 60000 ? 'red' : 'green' }}>Rent: ₹{office.rent}</p>
        <p>Address: {office.address}</p>
      </div>
      <h2>Available Offices</h2>
      <ul>
        {offices.map((off, index) => (
          <li key={index}>
            <p>Name: {off.name}</p>
            <p style={{ color: off.rent < 60000 ? 'red' : 'green' }}>Rent: ₹{off.rent}</p>
            <p>Address: {off.address}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;