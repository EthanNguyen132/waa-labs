import {useNavigate, useParams} from "react-router-dom";
import {useState, useEffect} from "react";
import productService from "../services/ProductService";


function ProductDetails() {
    const {id} = useParams();
    let navigate = useNavigate();

    const initialProduct = {
        id: null,
        title: "",
        quantity: 0,
        price: 0
    };
    const [currentProduct, setCurrentProduct] = useState(initialProduct);
    const [message, setMessage] = useState("");

    const getProduct = id => {
        productService.get(id)
            .then(response => {
                setCurrentProduct(response.data);
                // console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    useEffect(() => {
        if (id)
            getProduct(id);
    }, [id]);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setCurrentProduct({...currentProduct, [name]: value});
    };

    const updateProduct = () => {
        productService.update(currentProduct.id, currentProduct)
            .then(response => {
                console.log('update', response.data);
                setMessage("The product was updated successfully!");
            })
            .catch(e => {
                console.log(e);
            });
    };

    const deleteProduct = () => {
        productService.remove(currentProduct.id)
            .then(response => {
                console.log(response.data);
                navigate("/list");
            })
            .catch(e => {
                console.log(e);
            });
    };

    return (

        <div className="edit-form">
            <h4>Edit Product</h4>
            <form>
                <div className="form-group">
                    <label htmlFor="title">Title</label>
                    <input
                        type="text"
                        className="form-control"
                        id="title"
                        name="title"
                        value={currentProduct.title}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="price">Price</label>
                    <input
                        type="text"
                        className="form-control"
                        id="price"
                        name="price"
                        value={currentProduct.price}
                        onChange={handleInputChange}
                    />
                </div>
                <div className="form-group">
                    <label htmlFor="quantity">Quantity</label>
                    <input
                        type="text"
                        className="form-control"
                        id="quantity"
                        name="quantity"
                        value={currentProduct.quantity}
                        onChange={handleInputChange}
                    />
                </div>

            </form>

            <button className="btn btn-danger" onClick={deleteProduct}>
                Delete
            </button>

            <button
                type="submit"
                className="btn btn-danger"
                onClick={updateProduct}
            >
                Update
            </button>
            <p>{message}</p>
        </div>
    );
}

export default ProductDetails;