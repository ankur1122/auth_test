import logo from './logo.svg';
import './App.css';
import {useAuth0} from '@auth0/auth0-react'
import axios from 'axios'

function App() {
  const {getAccessTokenSilently, loginWithPopup,loginWithRedirect,logout,isAuthenticated,user} = useAuth0();

  function callunsafe() {
    axios.get("http://localhost:8080/open")
    .then(r => console.log(r))
    .catch(e => console.log(e))
  }
 async function callsafe() {
    const t = await getAccessTokenSilently();
    axios.get("http://localhost:8080/locked",{
      headers:{
        authorization:`Bearer ${t}`
      }
    })
    .then(r => console.log(r))
    .catch(e => console.log(e))
    // console.log(t);
  }

  return (
    <div className="App">
      <h1>Test</h1>
      <ul>
        <li><button onClick={loginWithPopup}>login with popup</button></li>
        <li><button onClick={loginWithRedirect}>login with redirect</button></li>
        <li><button onClick={logout}>logout</button></li>
        <li><button onClick={callunsafe}>open called</button></li>
        <li><button onClick={callsafe}>locked called</button></li>
      </ul>
      <h3>User {isAuthenticated?"logged in":"not logged in"}</h3>
      {isAuthenticated && (
        <pre style={{textAlign:"start"}}>
          {JSON.stringify(user,null,2)}
        </pre>
      )}
    </div>
  );
}

export default App;
