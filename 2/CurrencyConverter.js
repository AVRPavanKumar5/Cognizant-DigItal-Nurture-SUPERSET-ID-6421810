import React, { useState } from 'react';

function CurrencyConvertor() {
  const [inr, setInr] = useState(0);
  const [eur, setEur] = useState(0);
  const exchangeRate = 0.011; // Approximate INR to EUR rate

  const handleSubmit = (event) => {
    event.preventDefault();
    setEur(inr * exchangeRate);
  };

  return (
    <div>
      <h2>Currency Convertor</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={inr}
          onChange={(e) => setInr(e.target.value)}
          placeholder="Enter INR"
        />
        <button type="submit">Convert</button>
      </form>
      <p>EUR: {eur.toFixed(2)}</p>
    </div>
  );
}

export default CurrencyConvertor;