import {Routes, Route } from "react-router-dom"
import { useState } from 'react'
import './App.css'
import IncidentList from "./pages/IncidentList";
import IncidentDetail from "./pages/IncidentDetail";

function App() {

  return (
    <>
      <h1>Ticketboard</h1>
      <Routes>
        <Route path="/incidents" element={<IncidentList />} />
        <Route path="/incidents/:id" element={<IncidentDetail />} />
      </Routes>
    </>
  )
}

export default App
