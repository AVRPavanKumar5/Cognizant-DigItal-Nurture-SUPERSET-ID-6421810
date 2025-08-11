import React, { useState } from 'react';

function App() {
  const [counter, setCounter] = useState(0);

  const increment = () => {
    setCounter(counter + 1);
  };

  const sayHello = () => {
    alert('Hello! This is a static message.');
  };

  const handleIncrement = () => {
    increment();
    sayHello();
  };

  const decrement = () => {
    setCounter(counter - 1);
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = (event) => {
    event.preventDefault(); // Synthetic event usage
    alert('I was clicked');
  };

  return (
    <div>
      <h1>Event Examples App</h1>
      <p>Counter: {counter}</p>
      <button onClick={handleIncrement}>Increment</button>
      <button onClick={decrement}>Decrement</button>
      <button onClick={() => sayWelcome('Welcome')}>Say Welcome</button>
      <button onClick={handleClick}>OnPress (Synthetic Event)</button>
    </div>
  );
}

export default App;