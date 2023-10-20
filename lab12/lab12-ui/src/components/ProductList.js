import {useEffect, useState} from "react";

import productService from "../services/ProductService";
import {ListGroup} from "react-bootstrap";
import {Link} from "react-router-dom";


function ProductList() {
    const [products, setProducts] = useState([]);
    const [currentProduct, setCurrentProduct] = useState(null);
    const [currentIndex, setCurrentIndex] = useState(-1);

    useEffect(() => {
        const getProducts = async () => {
            try {
                const products = await productService.getAll();
                setProducts(products.data);
            } catch (e) {
                console.log(e);
            }
        };
        getProducts();
    }, []);

    const setActiveProduct = (product, index) => {
        console.log(product);
        setCurrentProduct(product);
        setCurrentIndex(index);
    };

    return (
        <div className="list row">
            <div className="col-md-6">
                <ListGroup>
                    {products && products.map((p, index) => (
                        <ListGroup.Item
                            key={p.id}
                            // href={"/products/" + currentProduct.id}
                            action active={index === currentIndex}
                            onClick={() => setActiveProduct(p, index)}>
                            {p.title}, {p.price}, {p.quantity}
                        </ListGroup.Item>
                    ))}
                </ListGroup>
            </div>
            <div className="col-md-6">
                {currentProduct ? (
                    <div>
                        <h4>Product Details</h4>
                        <div>
                            <label><strong>Title:</strong>
                            </label>{" "}{currentProduct.title}
                        </div>
                        <div>
                            <label><strong>Quantity:</strong>
                            </label>{" "} {currentProduct.quantity}
                        </div>
                        <div>
                            <label><strong>Price: </strong>
                            </label>{" "}{currentProduct.price}
                        </div>

                        <Link
                            to={"/product/" + currentProduct.id}
                            className="btn btn-danger"
                        >
                            Edit
                        </Link>
                    </div>
                ) : (
                    <div>
                        <br/>
                        <p>Please click on a Product...</p>
                    </div>
                )}
            </div>
        </div>
    );
}

export default ProductList;