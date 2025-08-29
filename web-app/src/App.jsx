import { useState } from "react";
import "./App.css";

// Sample video data (later you'll fetch from Firebase)
const videos = [
  {
    id: 1,
    url: "https://www.w3schools.com/html/mov_bbb.mp4",
    title: "My first auto-generated clip",
  },
  {
    id: 2,
    url: "https://www.w3schools.com/html/movie.mp4",
    title: "Another video from Firebase",
  },
];

function App() {
  const [currentIndex, setCurrentIndex] = useState(0);

  // Swipe up/down simulation with buttons (later: add real swipe/scroll)
  const handleNext = () => {
    setCurrentIndex((prev) => (prev + 1) % videos.length);
  };

  const handlePrev = () => {
    setCurrentIndex((prev) =>
      prev === 0 ? videos.length - 1 : prev - 1
    );
  };

  return (
    <div className="app">
      <div className="video-container">
        <video
          key={videos[currentIndex].id}
          src={videos[currentIndex].url}
          controls
          autoPlay
          loop
        />
        <div className="overlay">
          <h2>{videos[currentIndex].title}</h2>
          <div className="buttons">
            <button onClick={handlePrev}>⬆️ Prev</button>
            <button onClick={handleNext}>⬇️ Next</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default App;
