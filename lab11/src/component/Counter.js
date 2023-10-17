import {useState} from "react";

export default  function Counter() {
    const [counter, setCounter] = useState(0);

    const increase = () => {
        setCounter(counter + 1);
    }

    const decrease = () =>  {
        setCounter(counter - 1);
    }

    return (
        <>
            <h2>Counter: {counter}</h2>
            <button onClick={increase}>+ Increase</button>
            <button onClick={decrease}>- Decrease</button>
        </>
    )
}