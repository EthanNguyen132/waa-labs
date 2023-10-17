import {useRef} from "react";

export default function UseRefFocus() {
    const input = useRef(null);

    const focusInput = () => {
        input.current.focus();
    }

    return (
        <>
            <h2>UseRef Focus</h2>
            <input ref={input} type="text" />
            <button onClick={focusInput}>Focus</button>
        </>
    )

}