import { useEffect, useState } from "react";
import { getIncidents } from "../api";
import { Link } from "react-router-dom";

function IncidentList() {
    const [incidents, setIncidents] = useState<any[]>([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        getIncidents()
        .then(setIncidents)
        .catch(err => setError(err.message))
        .finally(() => setLoading(false));
    }, []);


    if (loading) return <p>Lade Incidents...</p>;
    if (error) return <p>Fehler: {error}</p>;

    return (
        <div>
            <h1>Incidents</h1>
            <ul>
                {incidents.map(i => (
                    <li key={i.id}>
                        <Link to={`/incidents/${i.id}`}>
                            {i.title} ({i.status})
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default IncidentList;