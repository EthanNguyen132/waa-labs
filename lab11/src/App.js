import './App.css';
import Counter from "./component/Counter";
import UseRefFocus from "./component/UseRefFocus";
import ColorLoop from "./component/ColorLoop";

function App() {
    return (
        <div className="App">
            <ColorLoop/>
            <Counter/>
            <UseRefFocus/>
        </div>
    );
}

export default App;
