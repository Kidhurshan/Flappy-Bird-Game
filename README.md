# 🐦 FlappyBird Game

A complete implementation of the classic FlappyBird game using Java Swing and AWT. Experience smooth gameplay with intuitive controls and engaging mechanics.

![FlappyBird Game](src/flappybirdbg.png)

## 🎮 Features

- **Smooth Gameplay**: 60 FPS game loop for fluid animation
- **Intuitive Controls**: Spacebar to flap, R-key to restart
- **Dynamic Obstacles**: Randomly generated pipes with varying gaps
- **Score Tracking**: Real-time score display during gameplay
- **Collision Detection**: Precise hit detection between bird and pipes
- **Game State Management**: Seamless transitions between play and game over states

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, NetBeans) or command line

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/flappybird-game.git
   cd flappybird-game
   ```

2. **Compile the project**
   ```bash
   javac -d out src/*.java
   ```

3. **Run the game**
   ```bash
   java -cp out Run
   ```

### Alternative: Using an IDE

1. Open the project in your preferred Java IDE
2. Navigate to `src/Run.java`
3. Run the `main` method

## 🎯 How to Play

- **Spacebar**: Make the bird flap upward
- **R Key**: Restart the game after game over
- **Objective**: Navigate through pipes without hitting them
- **Scoring**: Earn points by successfully passing through pipe gaps

## 🏗️ Project Structure

```
FlappyBird Game/
├── src/
│   ├── FlappyBird.java      # Main game logic and rendering
│   ├── Run.java             # Application entry point
│   ├── flappybird.png       # Bird sprite
│   ├── flappybirdbg.png     # Background image
│   ├── toppipe.png          # Top pipe sprite
│   └── bottompipe.png       # Bottom pipe sprite
├── out/                     # Compiled classes
└── README.md               # This file
```

## 🛠️ Technical Implementation

### Core Components

- **FlappyBird Class**: Main game panel extending JPanel
  - Implements KeyListener for input handling
  - Manages game loop and rendering
  - Handles collision detection and scoring

- **Bird Class**: Nested class representing the player character
  - Position tracking (x, y coordinates)
  - Size properties (width, height)
  - Velocity and gravity physics

- **Pipe Class**: Nested class for obstacle management
  - Position and size properties
  - Pass tracking for scoring
  - Image rendering

### Key Algorithms

1. **Game Loop**: Timer-based animation at 60 FPS
2. **Collision Detection**: AABB (Axis-Aligned Bounding Box) algorithm
3. **Physics Simulation**: Gravity and velocity calculations
4. **Pipe Generation**: Random positioning with consistent gaps

### Design Patterns

- **Observer Pattern**: Event-driven programming with ActionListener
- **State Pattern**: Game state management (playing, game over)
- **Factory Pattern**: Dynamic pipe creation

## 🎨 Graphics and Assets

The game uses custom sprite assets:
- **Bird**: 34x24 pixel sprite
- **Pipes**: 64x512 pixel sprites (top and bottom variants)
- **Background**: 360x640 pixel background image

All assets are loaded using Java's ImageIcon and getResource() methods for efficient resource management.

## 🔧 Customization

### Modifying Game Parameters

You can easily adjust game mechanics by modifying these variables in `FlappyBird.java`:

```java
int velocityBirdY = -10;    // Bird jump strength
int velocityPipeX = -4;      // Pipe movement speed
int gravity = 1;             // Gravity strength
```

### Adding New Features

The modular design makes it easy to extend:
- Add sound effects using Java Sound API
- Implement high score system with file I/O
- Create different difficulty levels
- Add power-ups or special effects

## 🐛 Known Issues

- Game window is non-resizable for consistent gameplay
- Limited to single-player mode
- No sound effects (can be added as enhancement)

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 🙏 Acknowledgments

- Inspired by the original FlappyBird game
- Built with Java Swing and AWT
- Created as a learning project for game development concepts

---

**Happy Gaming! 🎮**

*Made with ❤️ using Java* 