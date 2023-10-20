import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import ProductList from "./components/ProductList";
import AddProduct from "./components/AddProduct";
import ProductDetails from "./components/ProductDetails";

import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
    return (
        <BrowserRouter>

            <Navbar bg="dark" data-bs-theme="dark">
                <Container>
                    <Navbar.Brand href="#home">Lab12</Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Nav className="me-auto">
                            <Nav.Link href="/list">Product List</Nav.Link>
                            <Nav.Link href="/add">Add Product</Nav.Link>
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>

            <div className="container mt-3">
                <Routes>
                    <Route path="/" element={<ProductList/>}/>
                    <Route path="/list" element={<ProductList/>}/>
                    <Route path="/add" element={<AddProduct/>}/>
                    <Route path="/product/:id" element={<ProductDetails/>}/>
                </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
