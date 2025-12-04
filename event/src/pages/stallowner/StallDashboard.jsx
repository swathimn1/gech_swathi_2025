import React from 'react';
import { useNavigate } from 'react-router-dom';

const StallDashboard = () => {
  const navigate = useNavigate();

  const cards = [
    {
      id: 'stalls',
      title: 'Manage Stalls',
      description: 'View or edit your stall details and availability.',
      icon: '📅',
      color: '#007bff',
      buttonText: 'View Stalls',
      buttonColor: 'primary',
      route: '/stall-owner/stalls'
    },
    {
      id: 'upload',
      title: 'Upload Results',
      description: 'Post event outcomes or performance reports.',
      icon: '⬆️',
      color: '#28a745',
      buttonText: 'Upload Results',
      buttonColor: 'success',
      route: '/stall-owner/upload-results'
    },
    {
      id: 'attendance',
      title: 'Manage Attendance',
      description: 'Record attendance and visitor logs.',
      icon: '📋',
      color: '#ffc107',
      buttonText: 'Attendance',
      buttonColor: 'warning',
      route: '/stall-owner/attendance'
    },
    {
      id: 'notifications',
      title: 'Notifications',
      description: 'Stay updated with latest event news and alerts.',
      icon: '🔔',
      color: '#dc3545',
      buttonText: 'View Alerts',
      buttonColor: 'danger',
      route: '/stall-owner/notifications'
    }
  ];

  return (
    <div className="container py-5">
      <div className="text-center mb-5">
        <h1 className="display-4 text-white fw-bold">Welcome, Stall Owner 🎪</h1>
      </div>
      
      <div className="row g-4">
        {cards.map(card => (
          <div key={card.id} className="col-12 col-md-6 col-lg-3">
            <div className="card h-100 shadow-lg border-0">
              <div className="card-body text-center p-4">
                <div className="mb-3" style={{ fontSize: '3rem' }}>{card.icon}</div>
                <h5 className="card-title fw-bold mb-3">{card.title}</h5>
                <p className="card-text text-muted mb-4">{card.description}</p>
                <button 
                  className={`btn btn-${card.buttonColor} w-100`}
                  onClick={() => navigate(card.route)}
                >
                  {card.buttonText}
                </button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default StallDashboard;