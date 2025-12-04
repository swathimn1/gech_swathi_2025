import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

const Dashboard = () => {
  const navigate = useNavigate();
  const [points, setPoints] = useState(0);
  const [eventsCount, setEventsCount] = useState(0);

  useEffect(() => {
    // Load points from localStorage
    const savedPoints = localStorage.getItem('userPoints');
    if (savedPoints) {
      setPoints(parseInt(savedPoints));
    }

    // Load events count
    const events = JSON.parse(localStorage.getItem('events') || '[]');
    setEventsCount(events.length);
  }, []);

  const cards = [
    {
      id: 1,
      title: 'Browse Events',
      subtitle: `${eventsCount} available events`,
      icon: '📅',
      color: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)',
      path: '/admin/events'
    },
    {
      id: 2,
      title: 'Scan QR Code',
      subtitle: 'Earn points by scanning stalls',
      icon: '📱',
      color: 'linear-gradient(135deg, #f093fb 0%, #f5576c 100%)',
      path: '/admin/qrcode'
    },
    {
      id: 3,
      title: 'My Feedback',
      subtitle: 'View your stall ratings',
      icon: '⭐',
      color: 'linear-gradient(135deg, #4facfe 0%, #00f2fe 100%)',
      path: '/admin/feedback'
    },
    {
      id: 4,
      title: 'My Queries',
      subtitle: 'Track your questions',
      icon: '💬',
      color: 'linear-gradient(135deg, #43e97b 0%, #38f9d7 100%)',
      path: '/admin/queries'
    }
  ];

  const handleCardClick = (path) => {
    navigate(path);
  };

  return (
    <div style={{ 
      minHeight: '100vh', 
      background: 'linear-gradient(135deg, #667eea 0%, #764ba2 100%)',
      padding: '20px'
    }}>
      <div className="container">
        {/* Points Card */}
        <div className="card shadow-lg mb-4" style={{ borderRadius: '20px', border: 'none' }}>
          <div className="card-body text-center py-5">
            <div className="mb-3">
              <span style={{ fontSize: '3rem' }}>🏆</span>
            </div>
            <h2 className="fw-bold mb-3">Your Points</h2>
            <h1 className="display-1 fw-bold text-primary mb-3">{points}</h1>
            <p className="text-muted">Keep scanning to earn more!</p>
          </div>
        </div>

        {/* Cards Grid */}
        <div className="row g-4">
          {cards.map((card) => (
            <div key={card.id} className="col-md-6 col-lg-3">
              <div
                className="card shadow-lg h-100 border-0"
                style={{
                  borderRadius: '20px',
                  background: card.color,
                  cursor: 'pointer',
                  transition: 'transform 0.3s ease, box-shadow 0.3s ease',
                }}
                onClick={() => handleCardClick(card.path)}
                onMouseEnter={(e) => {
                  e.currentTarget.style.transform = 'translateY(-10px)';
                  e.currentTarget.style.boxShadow = '0 20px 40px rgba(0,0,0,0.3)';
                }}
                onMouseLeave={(e) => {
                  e.currentTarget.style.transform = 'translateY(0)';
                  e.currentTarget.style.boxShadow = '0 10px 20px rgba(0,0,0,0.2)';
                }}
              >
                <div className="card-body text-center text-white py-5">
                  <div className="mb-3" style={{ fontSize: '3rem' }}>
                    {card.icon}
                  </div>
                  <h4 className="fw-bold mb-2">{card.title}</h4>
                  <p className="mb-0 opacity-75">{card.subtitle}</p>
                </div>
              </div>
            </div>
          ))}
        </div>

        {/* Stats Section */}
        <div className="row mt-5">
          <div className="col-12">
            <div className="card shadow-lg" style={{ borderRadius: '20px', border: 'none' }}>
              <div className="card-body p-4">
                <h5 className="fw-bold mb-4">Quick Stats</h5>
                <div className="row text-center">
                  <div className="col-6 col-md-3 mb-3">
                    <h3 className="text-primary fw-bold">{points}</h3>
                    <small className="text-muted">Total Points</small>
                  </div>
                  <div className="col-6 col-md-3 mb-3">
                    <h3 className="text-success fw-bold">{eventsCount}</h3>
                    <small className="text-muted">Events</small>
                  </div>
                  <div className="col-6 col-md-3 mb-3">
                    <h3 className="text-warning fw-bold">
                      {JSON.parse(localStorage.getItem('feedback') || '[]').length}
                    </h3>
                    <small className="text-muted">Feedback</small>
                  </div>
                  <div className="col-6 col-md-3 mb-3">
                    <h3 className="text-info fw-bold">
                      {JSON.parse(localStorage.getItem('queries') || '[]').length}
                    </h3>
                    <small className="text-muted">Queries</small>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Dashboard;