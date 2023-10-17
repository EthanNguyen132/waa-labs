import {useEffect, useState} from "react";

export default function ColorLoop() {
    const colors = ["red", "yellow", "green"];
    const [currentColorIndex, setCurrentColorIndex] = useState(0);
    const [mounted, setMounted] = useState(true);

    useEffect(() => {
        let timer;
        if (mounted) {
            timer = setInterval(() => {
                console.log("current index ", currentColorIndex);
                let index = currentColorIndex === colors.length - 1 ? 0 : currentColorIndex + 1;
                console.log("new index ", index);
                setCurrentColorIndex(index);
            }, 1000);
        }
        return () => clearInterval(timer);
    }, [mounted, currentColorIndex, colors.length])

    const unMountLooper = () => {
        console.log("unmounting....");
        setMounted(false);
    }
    return (
        <>
            {mounted && <h1>Looping color {colors[currentColorIndex]}</h1>}
            {/*<h1>Looping color {colors[currentColorIndex]}</h1>*/}
            <button onClick={unMountLooper}>Unmount</button>
        </>
    )
}