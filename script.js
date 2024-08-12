let board = ['', '', '', '', '', '', '', '', ''];
let currentPlayer = 'X';
let gameActive = true;
const statusDisplay = document.querySelector('#status');

function handleCellPlayed(cellIndex) {
    board[cellIndex] = currentPlayer;
    document.getElementById(cellIndex).innerText = currentPlayer;
}

function handlePlayerChange() {
    currentPlayer = currentPlayer === 'X' ? 'O' : 'X';
    statusDisplay.innerText = `It's ${currentPlayer}'s turn`;
}

function checkWin() {
    const winningConditions = [
        [0, 1, 2], [3, 4, 5], [6, 7, 8], 
        [0, 3, 6], [1, 4, 7], [2, 5, 8], 
        [0, 4, 8], [2, 4, 6]             
    ];

    let roundWon = false;
    for (let i = 0; i < winningConditions.length; i++) {
        const [a, b, c] = winningConditions[i];
        if (board[a] && board[a] === board[b] && board[a] === board[c]) {
            roundWon = true;
            break;
        }
    }

    if (roundWon) {
        statusDisplay.innerText = `Player ${currentPlayer} has won!`;
        gameActive = false;
        return true;
    }

    if (!board.includes('')) {
        statusDisplay.innerText = 'It\'s a draw!';
        gameActive = false;
        return true;
    }

    return false;
}

function handleCellClick(event) {
    const clickedCell = event.target;
    const cellIndex = parseInt(clickedCell.getAttribute('id'));

    if (board[cellIndex] !== '' || !gameActive) {
        return;
    }

    handleCellPlayed(cellIndex);
    if (!checkWin()) {
        handlePlayerChange();
    }
}

function handleRestartGame() {
    board = ['', '', '', '', '', '', '', '', ''];
    gameActive = true;
    currentPlayer = 'X';
    document.querySelectorAll('.cell').forEach(cell => cell.innerText = '');
    statusDisplay.innerText = `It's ${currentPlayer}'s turn`;
}

document.querySelectorAll('.cell').forEach(cell => cell.addEventListener('click', handleCellClick));
document.querySelector('#reset').addEventListener('click', handleRestartGame);

const boardElement = document.getElementById('board');
for (let i = 0; i < 9; i++) {
    const cell = document.createElement('div');
    cell.classList.add('cell');
    cell.setAttribute('id', i);
    boardElement.appendChild(cell);
}

statusDisplay.innerText = `It's ${currentPlayer}'s turn`;
