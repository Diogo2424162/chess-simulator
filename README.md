# ChessSimulator

A Java object-oriented programming (OOP) study project focused on modeling a configurable 2D board grid, representing pieces as objects, and simulating piece movement and attack patterns.

## Overview & Motivation

This repository tracks the transition from a procedural grid experiment to a structured OOP design in Java:

- **Procedural prototype (`QuennChess.java`)**: Explores queen movement/attack logic on an `int[][]` matrix across rows, columns, and diagonals, including matrix cloning, step-by-step console output, and diff rendering (`printBoardChanges`) between states.
- **OOP refactor draft (`ChessSimulator.java`)**: Begins modeling the simulation with `Board` and `Piece` classes, a `Piece[][]` grid initialized with a default empty piece (`StarterPiece`), coordinate bounds checking (`isInBoard`), and console rendering toggling between piece names and symbols.

## Architecture Plan

The core design separates board state and piece behavior so rules can scale cleanly across different board dimensions and piece types:

- **`Board`**: Owns the `Piece[][]` grid, dimensions (`rows` and `columns`), board name, bounds validation, and rendering helpers.
- **`Piece`**: Represents an entity or cell state on the board (such as an empty/starter piece or a specific chess piece) and will eventually define valid moves and attack vectors relative to the board.
- **Simulation / Rules Layer**: Coordinates turn or step progression, movement validation, and board state updates without coupling matrix loops directly to raw console prints.

## Current Status

- [x] Prototype step-by-step queen attack simulation on `int[][]` matrices (`QuennChess.java`).
- [x] Draft initial `Board` and `Piece` inner classes, grid initialization, bounds checking, and name/symbol printing (`ChessSimulator.java`).
- [ ] Extract `Board` and `Piece` into clean standalone/top-level classes and standardize naming.
- [ ] Port queen movement/attack logic onto the `Piece[][]` board model.

## Planned Improvements & Known Quirks

- **Naming & typos**: Standardize identifiers (`QuennChess` -> `QueenChess`, `simbol` -> `symbol`, `colums` -> `columns`, `StarterPiece` -> `starterPiece` / `EMPTY_PIECE`) and avoid over-abbreviated method names.
- **Class structure**: Move `Board` and `Piece` out of nested/instance scope so they can be instantiated and extended cleanly across files.
- **Diagonal & boundary logic**: Review diagonal loop termination and `try/catch` boundary handling in the prototype so out-of-bounds checks happen explicitly via `isInBoard` rather than catching exceptions.
- **Rendering & state**: Separate grid state from `System.out.print` formatting so board states are easier to inspect, test, and reuse.