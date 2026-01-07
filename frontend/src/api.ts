const BASE_URL = import.meta.env.VITE_API_BASE_URL;

async function request<T>(url: string): Promise<T> {
    const response = await fetch(`${BASE_URL}${url}`);

    if(!response.ok) {
        throw new Error(`API error: ${response.status}`);
    }

    return response.json();
}

export function getIncidents() {
    return request<any[]>("/incidents");
}

export function getIncident(id: number) {
    return request<any>(`/incidents/${id}`);
}

export function getComments(incidentId: number) {
    return request<any[]>(`/incidents/${incidentId}/comments`);
}