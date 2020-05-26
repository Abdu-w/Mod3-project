import React, { Component } from 'react';
// import axios from 'axios'
import './App.css';
import InitialCall from './components/InitialCall';
import Nav from './components/Navbar'


function App () {
  return (
    <div className="App">
    <Nav />
    <InitialCall />
    </div>
  )
}

export default App;