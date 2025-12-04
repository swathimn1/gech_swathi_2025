import { API_BASE_URL, getAuthHeader } from '../config/api';

class ApiService {
  async request(endpoint, options = {}) {
    const config = {
      ...options,
      headers: {
        'Content-Type': 'application/json',
        ...getAuthHeader(),
        ...options.headers,
      },
    };

    try {
      const response = await fetch(`${API_BASE_URL}${endpoint}`, config);
      const contentType = response.headers.get('content-type');

      if (!response.ok) {
        let errorMessage = `HTTP error! status: ${response.status}`;
      
        if (contentType && contentType.includes('application/json')) {
          try {
            const error = await response.json();
            errorMessage = error.message || error.error || errorMessage;
          } catch {
            // fallback to default message
          }
        } else {
          const text = await response.text();
          console.error('Non-JSON error response:', text);
        }
      
        throw new Error(errorMessage);
      }
      

      if (contentType && contentType.includes('application/json')) {
        return response.json();
      } else {
        const text = await response.text();
        console.warn('Non-JSON success response:', text);
        return text;
      }
    } catch (err) {
      console.error('API request failed:', err.message);
      throw err;
    }
  }

  get(endpoint) {
    return this.request(endpoint);
  }

  post(endpoint, data) {
    return this.request(endpoint, {
      method: 'POST',
      body: JSON.stringify(data),
    });
  }

  put(endpoint, data) {
    return this.request(endpoint, {
      method: 'PUT',
      body: JSON.stringify(data),
    });
  }

  delete(endpoint) {
    return this.request(endpoint, {
      method: 'DELETE',
    });
  }
}

export const apiService = new ApiService();