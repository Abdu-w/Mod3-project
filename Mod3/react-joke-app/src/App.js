import React, { Component } from 'react';
import InitialCall from './components/InitialCall';
import Nav from './components/Navbar';
import './App.css';

function App () {
  return (
    <div className="App">
    <Nav />
    <InitialCall />
    </div>
  )
}

export default App;
