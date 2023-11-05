import { useEffect } from "react";
import "./App.css";
import { useLocalState } from "./util/useLocalStorage";
import Dashboard from "./Dashboard";
import { Router, Route, Routes } from "react-router-dom";
import HompePage from "./HomePage";
import Login from "./Login";
import PrivateRoute from "./PrivateRoute";
import AssignmentView from "./AssignmentView";
import "bootstrap/dist/css/bootstrap.min.css";

function App() {
  const [jwt, setJwt] = useLocalState("", "jwt");

  // useEffect(() => {
  //   console.log(`JWT is: ${jwt}`);
  // }, [jwt]);

  return (
    <Routes>
      <Route
        path="/dashboard"
        element={
          <PrivateRoute>
            <Dashboard />
          </PrivateRoute>
        }
      />
      <Route
        path="/assignments/:id"
        element={
          <PrivateRoute>
            <AssignmentView></AssignmentView>
          </PrivateRoute>
        }
      />
      <Route path="/login" element={<Login />}></Route>
      <Route path="/" element={<HompePage />} />
    </Routes>
  );
}

export default App;
