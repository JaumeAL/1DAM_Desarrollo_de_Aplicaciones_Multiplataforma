function SnakeGame() {
    this.canvas = document.getElementById('gameCanvas');
    this.context = this.canvas.getContext('2d');
    this.snake = [{ x: 10, y: 10 }];
    this.food = {};
    this.direction = 'RIGHT';
    this.score = 0;
    this.gameInterval = null;

    this.init = function() {
        this.createFood();
        this.gameInterval = setInterval(this.update.bind(this), 100);
        document.addEventListener('keydown', this.changeDirection.bind(this));
    };

    this.createFood = function() {
        this.food = {
            x: Math.floor(Math.random() * (this.canvas.width / 10)) * 10,
            y: Math.floor(Math.random() * (this.canvas.height / 10)) * 10
        };
    };

    this.changeDirection = function(event) {
        const keyPressed = event.keyCode;
        if (keyPressed === 37 && this.direction !== 'RIGHT') {
            this.direction = 'LEFT';
        } else if (keyPressed === 38 && this.direction !== 'DOWN') {
            this.direction = 'UP';
        } else if (keyPressed === 39 && this.direction !== 'LEFT') {
            this.direction = 'RIGHT';
        } else if (keyPressed === 40 && this.direction !== 'UP') {
            this.direction = 'DOWN';
        }
    };

    this.update = function() {
        this.moveSnake();
        this.checkCollision();
        this.draw();
    };

    this.moveSnake = function() {
        const head = { ...this.snake[0] };
        if (this.direction === 'LEFT') head.x -= 10;
        if (this.direction === 'UP') head.y -= 10;
        if (this.direction === 'RIGHT') head.x += 10;
        if (this.direction === 'DOWN') head.y += 10;

        this.snake.unshift(head);
        if (head.x === this.food.x && head.y === this.food.y) {
            this.score++;
            this.createFood();
        } else {
            this.snake.pop();
        }
    };

    this.checkCollision = function() {
        const head = this.snake[0];
        if (head.x < 0 || head.x >= this.canvas.width || head.y < 0 || head.y >= this.canvas.height || this.snake.slice(1).some(segment => segment.x === head.x && segment.y === head.y)) {
            clearInterval(this.gameInterval);
            alert('Game Over! Your score: ' + this.score);
            document.location.reload();
        }
    };

    this.draw = function() {
        this.context.clearRect(0, 0, this.canvas.width, this.canvas.height);
        this.context.fillStyle = 'green';
        this.snake.forEach(segment => {
            this.context.fillRect(segment.x, segment.y, 10, 10);
        });
        this.context.fillStyle = 'red';
        this.context.fillRect(this.food.x, this.food.y, 10, 10);
        this.context.fillStyle = 'black';
        this.context.fillText('Score: ' + this.score, 10, 10);
    };
}

const game = new SnakeGame();
game.init();