import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { getIncident, getComments } from "../api";

function IncidentDetail() {
    const { id } = useParams();
    const incidentId = Number(id);

    const [incident, setIncident] = useState<any | null>(null);
    const [comments, setComments] = useState<any[]>([]);

    useEffect(() => {
        getIncident(incidentId).then(setIncident);
        getComments(incidentId).then(setComments);
    }, [incidentId]);

    if (!incident) return <p>Lade Incidents...</p>

    return (
        <div>
            <h1>{incident.title}</h1>
            <p>Status: {incident.status}</p>
            <p>Severity: {incident.severity}</p>

            {incident.resolution && (
                <>
                    <h2>Resolution</h2>
                    <p>{incident.resolution}</p>
                </>
            )}

            <h2>Comments</h2>
            {comments.length === 0 && <p>Noch keine Kommentare</p>}
            <ul>
                {comments.map(c => (
                    <li key={c.id}>
                        <strong>{c.author ?? "System"}:</strong> {c.message}
                    </li>
                ))}
            </ul>
        </div>
    );

}

export default IncidentDetail;