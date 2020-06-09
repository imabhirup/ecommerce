import React from 'react';
import '../src/logo.png';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'font-awesome-4.7.0/css/font-awesome.min.css';

function App() {
  return (
    <nav className="navbar1">
      <div className="container">
        <div className="row">
          <div className="col-2">
            <a className="brand" href="index.html">
              <i className="fa fa-shopping-cart fa-2x"></i>
              &nbsp;
              AMEZSTORE
            </a>
          </div>
          <div className="col-10">
            <div className="row">
              <div className="col-7">
                <from className="form-inline">
                  <input className="form-control" id="inputfld" type="search" aria-label="Search" placeholder="Search categories or products" />
                  <button className="btn btn-outline-success">
                    <i className="fa fa-search"></i>
                  </button>
                </from>
              </div>
              <div className="col-3 nav-item borderXwidth">
                <a className="nav-link" href="login.html">LOGIN | SIGNUP</a>
              </div>
              <div className="col-2 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">FAQ</a>
              </div>
            </div>

            <div className="row">
              <div className="col-2 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">ALL PRODUCTS</a>
              </div>
              <div className="col-1 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">MEN</a>
              </div>
              <div className="col-2 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">WOMEN</a>
              </div>
              <div className="col-1 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">KIDS</a>
              </div>
              <div className="col-3 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">WORLD CRAFTS</a>
              </div>
              <div className="col-2 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">NEW ARRIVALS</a>
              </div>
              <div className="col-1 nav-item borderXwidth">
                <a className="nav-link" href="faq.html">
                  <i className="fa fa-shopping-cart"></i>
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>

  );
}

export default App;
