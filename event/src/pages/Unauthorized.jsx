import { Link } from 'react-router-dom';
import { Button } from '../components/ui/button';
import { ShieldAlert } from 'lucide-react';
import Layout from '../components/Layout';

const Unauthorized = () => {
  return (
    
    <Layout>
    <div className="flex min-h-screen items-center justify-center bg-background">
      <div className="text-center space-y-6">
        <ShieldAlert className="w-24 h-24 mx-auto text-destructive" />
        <h1 className="text-4xl font-bold">Access Denied</h1>
        <p className="text-xl text-muted-foreground max-w-md">
          You don't have permission to access this page.
        </p>
        <Button asChild>
          <Link to="/">Go Home</Link>
        </Button>
      </div>
    </div>
    </Layout>
  );
};

export default Unauthorized;
