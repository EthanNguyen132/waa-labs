import {useState} from "react";
import productService from "../services/ProductService";
import {Button, Form} from "react-bootstrap";

export default function AddProduct() {
    const initialProduct = {
        id: null,
        title: "",
        quantity: 0,
        price: 0
    };
    const [product, setProduct] = useState(initialProduct);
    const [submitted, setSubmitted] = useState(false);

    const handleInputChange = event => {
        const {name, value} = event.target;
        setProduct({...product, [name]: value});
    };

    const saveProduct = () => {
        let data = {
            title: product.title,
            quantity: product.quantity,
            price: product.price
        };

        productService.create(data)
            .then(response => {
                setProduct({
                    id: response.data.id,
                    firstName: response.data.firstName,
                    lastName: response.data.lastName,
                    age: response.data.age
                });
                setSubmitted(true);
                console.log(response.data);
            })
            .catch(e => {
                console.log(e);
            });
    };

    const clearForm = () => {
        setProduct(initialProduct);
        setSubmitted(false);
    };

    return (
        <Form>
            {
                submitted ?
                    (
                        <>
                            <h4>You submitted successfully!</h4>
                            <Button variant="primary" type="button" onClick={clearForm}>Add another product</Button>
                        </>
                    ) :
                    (
                        <>
                            <Form.Group className="mb-3" controlId="formBasicTitle">
                                <Form.Label>Title</Form.Label>
                                <Form.Control type="text" placeholder="Enter title"
                                              required name="title"
                                              value={product.title}
                                              onChange={handleInputChange}/>
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="formBasicPrice">
                                <Form.Label>Price</Form.Label>
                                <Form.Control type="number" placeholder="Enter price"
                                              required name="price"
                                              value={product.price}
                                              onChange={handleInputChange}/>
                            </Form.Group>
                            <Form.Group className="mb-3" controlId="formBasicQuantity">
                                <Form.Label>Quantity</Form.Label>
                                <Form.Control type="number" placeholder="Enter quantity"
                                              required name="quantity"
                                              value={product.quantity}
                                              onChange={handleInputChange}/>
                            </Form.Group>

                            <Button variant="primary" type="button" onClick={saveProduct}>Submit</Button>
                        </>
                    )
            }


        </Form>

        // <div className="submit-form">
        //     {submitted ? (
        //         <div>
        //             <h4>You submitted successfully!</h4>
        //             <button className="btn btn-success" onClick={clearForm}>
        //                 Add
        //             </button>
        //         </div>
        //     ) : (
        //         <div>
        //             <div className="form-group">
        //                 <label htmlFor="title">Title</label>
        //                 <input
        //                     type="text"
        //                     className="form-control"
        //                     id="title"
        //                     required
        //                     value={product.title}
        //                     onChange={handleInputChange}
        //                     name="title"
        //                 />
        //             </div>
        //
        //             <div className="form-group">
        //                 <label htmlFor="price">Price</label>
        //                 <input
        //                     type="text"
        //                     className="form-control"
        //                     id="price"
        //                     required
        //                     value={product.price}
        //                     onChange={handleInputChange}
        //                     name="price"
        //                 />
        //             </div>
        //
        //             <div className="form-group">
        //                 <label htmlFor="quantity">Quantity</label>
        //                 <input
        //                     type="text"
        //                     className="form-control"
        //                     id="quantity"
        //                     required
        //                     value={product.quantity}
        //                     onChange={handleInputChange}
        //                     name="quantity"
        //                 />
        //             </div>
        //
        //             <button onClick={saveProduct} className="btn btn-success">
        //                 Submit
        //             </button>
        //         </div>
        //     )}
        // </div>
    );

}