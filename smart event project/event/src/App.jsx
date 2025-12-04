import { Toaster as Sonner } from "./components/ui/sonner";
import { Toaster } from "./components/ui/toaster.jsx";
import { TooltipProvider } from "./components/ui/tooltip";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import { AuthProvider } from "./context/AuthContext";
import { ProtectedRoute } from "./components/ProtectedRoute";

// Pages (Public)
import Index from "./pages/Index";
import Login from "./pages/Login";
import Signup from "./pages/SignUp.jsx";
import Unauthorized from "./pages/Unauthorized";
import NotFound from "./pages/NotFound";
import Events from "./pages/Events.jsx";
import EventStallPage from "./pages/EventStallPage.jsx";
import Logout from "./pages/Logout.jsx";
import Users from "./pages/Users.jsx";
import FeedbackManagement from "./pages/FeedbackManagement.jsx";

// Admin Pages
import AdminDashboard from "./pages/admin/AdminDashboard.jsx";
import AdminEventsPage from "./pages/admin/AdminEventsPage.jsx";
import AdminStallsPage from "./pages/admin/AdminStallsPage.jsx";
import AdminUserList from "./pages/admin/AdminUserList.jsx";

// Stall Owner Pages
import StallOwnerDashboard from "./pages/stallowner/StallOwnerDashboard.jsx";
import ViewStalls from "./pages/stallowner/ViewStalls.jsx";
// import UploadResults from "./pages/stallowner/UploadResults.jsx";
// import ManageAttendance from "./pages/stallowner/ManageAttendance.jsx";
// import Notifications from "./pages/stallowner/Notifications.jsx";

// Visitor Pages
import VisitorDashboard from "./pages/visitor/VisitorDashboard.jsx";
import Feedback from "./pages/Feedback.jsx";
import Queries from "./pages/Queries.jsx";
import QRScanner from "./components/QRScanner.jsx";
// import StallOwnerLayout from "./layouts/StallOwnerLayout.jsx";
// import StallDashboard from "./pages/stallowner/StallDashboard.jsx";
import ManageStalls from "./pages/stallowner/ManageStalls.jsx";
import UploadResults from "./pages/stallowner/UploadResults.jsx";
import ManageAttendance from "./pages/stallowner/ManageAttendance.jsx";
import Notifications from "./pages/stallowner/Notifications.jsx";
import CheckIn from "./pages/CheckIn.jsx";
import Contact from "./pages/Contact.jsx";
import About from "./pages/About.jsx";
// import ManageStallsPage from "./pages/admin/ManageStallsPage.jsx";
import EmailPreviewPage from "./pages/EmailPreviewPage.jsx";
import AdminQRScanner from "./components/AdminQRScanner.jsx";
import QueriesPage from "./pages/admin/QueriesPage.jsx";
import EventDetail from "./pages/EventDetail.jsx";
// import Analytics from "./pages/admin/Analytics.jsx";
// import { Contact } from "lucide-react";

const queryClient = new QueryClient();

const App = () => (
  <QueryClientProvider client={queryClient}>
    <AuthProvider>
      <TooltipProvider>
        <Toaster />
        <Sonner />
        <BrowserRouter>
          <Routes>
            {/* Public Routes */}
            <Route path="/" element={<Index />} />
            <Route path="/login" element={<Login />} />
            <Route path="/auth/login" element={<Login />} />

            <Route path="/signup" element={<Signup />} />
            <Route path="/auth/signup" element={<Signup />} />

            <Route path="/register" element={<Signup />} />
            <Route path="/logout" element={<Logout />} />
            <Route path="/users" element={<AdminUserList />} />
            <Route path="/unauthorized" element={<Unauthorized />} />
            <Route path="/events" element={<Events />} />
            <Route path="/events/:id" element={<EventStallPage />} />
            <Route path="/feedback" element={<FeedbackManagement />} />
            <Route path="/visitor/events" element={<Events />} />
            <Route path="/visitor/feedback" element={<Feedback />} />
            <Route path="/visitor/queries" element={<Queries />} />
            <Route path="/admin/feedback" element={<FeedbackManagement />} />
            <Route path="/visitor/scan" element={<QRScanner />} />
            <Route path="/checkin" element={<CheckIn />} />
            <Route path="/about" element={<About />} />
            <Route path="/contact" element={<Contact />} />
            <Route path="/admin/qrcode" element={<AdminQRScanner />} />
            <Route path="/admin/queries" element={<Queries />} />
            <Route path="/visitor/event-details/:id" element={<EventDetail />} />
            {/* <Route path="/email-preview" element={<EmailPreviewList />} />
        <Route path="/email-preview/welcome-visitor" element={<WelcomeVisitorPreview />} />
        <Route path="/email-preview/stall-approved" element={<StallApprovedPreview />} />
        <Route path="/email-preview/query-notification" element={<QueryNotificationPreview />} />
        <Route path="/email-preview/feedback-received" element={<FeedbackReceivedPreview />} /> */}
            <Route path="/email-preview" element={<EmailPreviewPage />} />
            
            {/* <Route path="/admin/stalls" element={<ManageStallsPage />} /> */}

            {/* <Route path="/admin/analytics" element={<Analytics />} /> */}


            
            {/* <Route path="/admin/dashboard" element={<AdminDashboard />} /> */}





            {/* <Route path="/stall-owner" element={<StallOwnerLayout />} /> */}
            {/* <Route index element={<Navigate to="/stallowner/dashboard" replace />} /> */}
            {/* <Route path="dashboard" element={<StallDashboard />} /> */}
            <Route path="/stall-owner/stalls" element={<ManageStalls />} />
            <Route
              path="/stall-owner/upload-results"
              element={<UploadResults />}
            />
            <Route
              path="/stall-owner/attendance"
              element={<ManageAttendance />}
            />
            <Route
              path="/stall-owner/notifications"
              element={<Notifications />}
            />

            {/* Protected Admin Routes */}
            <Route
              path="/admin/dashboard"
              element={
                <ProtectedRoute allowedRoles={["ADMIN"]}>
                  <AdminDashboard />
                </ProtectedRoute>
              }
            />
            <Route
              path="/admin/events"
              element={
                <ProtectedRoute allowedRoles={["ADMIN"]}>
                  <AdminEventsPage />
                </ProtectedRoute>
              }
            />
            <Route
              path="/admin/stalls"
              element={
                <ProtectedRoute allowedRoles={["ADMIN"]}>
                  <AdminStallsPage />
                </ProtectedRoute>
              }
            />
            <Route
              path="/admin/users"
              element={
                <ProtectedRoute allowedRoles={["ADMIN"]}>
                  <AdminUserList />
                </ProtectedRoute>
              }
            />

            {/* Protected Stall Owner Routes */}
            <Route
              path="/stall-owner/dashboard"
              element={
                <ProtectedRoute allowedRoles={["STALL_OWNER","ADMIN"]}>
                  <StallOwnerDashboard />
                </ProtectedRoute>
              }
            />
             {/* <Route
              path="/stall-owner/dashboard"
              element={
                
                  <StallOwnerDashboard />
                
              }
            /> */}
            {/* <Route
              path="/stall-owner/stalls"
              element={
                <ProtectedRoute allowedRoles={["STALL_OWNER"]}>
                  <ViewStalls />
                </ProtectedRoute>
              }
            /> */}

            {/* Protected Visitor Routes */}
            <Route
              path="/visitor/dashboard"
              element={
                <ProtectedRoute allowedRoles={["VISITOR","ADMIN"]}>
                  <VisitorDashboard />
                </ProtectedRoute>
              }
            />
            {/* <Route
              path="/visitor/dashboard"
              element={
                
                  <VisitorDashboard />
                
              }
            /> */}

            {/* Catch-all for undefined routes */}
            <Route path="*" element={<NotFound />} />
          </Routes>
        </BrowserRouter>
      </TooltipProvider>
    </AuthProvider>
  </QueryClientProvider>
);

export default App;
