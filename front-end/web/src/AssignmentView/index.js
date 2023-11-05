import React, { useEffect, useState } from "react";
import { useLocalState } from "../util/useLocalStorage";
import ajax from "../Services/fetchServices";

const AssignmentView = () => {
  const [jwt, setJwt] = useLocalState("", "jwt");
  const assignmentId = window.location.href.split("/assignments/")[1];
  const [assignment, setAssignments] = useState({
    branch: "",
    githubUrl: "",
  });

  // const [gitHubUrl, setGithubUrl] = useState("", "");
  // const [branch, setBranch] = useState("", "");

  function updateAssignments(prop, value) {
    const newAssignment = { ...assignment };

    newAssignment[prop] = value;
    setAssignments(newAssignment);
    console.log(assignment);
  }

  function save() {
    ajax(`/api/assignments/${assignmentId}`, "PUT", jwt, assignment).then(
      (assignmentsData) => {
        setAssignments(assignmentsData);
      }
    );
  }

  useEffect(() => {
    ajax(`/api/assignments/${assignmentId}`, "GET", jwt).then(
      (assignmentsData) => {
        if (assignmentsData.branch === null) assignmentsData.branch = "";
        if (assignmentsData.gitHubUrl === null) assignmentsData.gitHubUrl = "";
        setAssignments(assignmentsData);
      }
    );
  }, []);

  return (
    <div>
      <h1>Assignment {assignmentId}</h1>
      {assignment ? (
        <>
          <h2>Status: {assignment.status}</h2>
          <h3>
            Github url:{" "}
            <input
              type="url"
              id="githubUrl"
              onChange={(e) => updateAssignments("githubUrl", e.target.value)}
              value={assignment.githubUrl}
            ></input>
          </h3>
          <h3>
            Branch :{" "}
            <input
              type="text"
              id="branch"
              onChange={(e) => updateAssignments("branch", e.target.value)}
              value={assignment.branch}
            ></input>
          </h3>
          <button onClick={() => save()}>Submit Assignment</button>
        </>
      ) : (
        <></>
      )}
    </div>
  );
};

export default AssignmentView;
