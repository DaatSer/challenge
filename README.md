# Crossmint ADR

## Context
The goal is to develop an automated application that generates a matrix of custom shape and form, applying a metaverse design.

### Example of Phase 1-2 Matrix:

## Requirements
- Clean, understandable code.
- Proper modeling of the problem with appropriate classes/interfaces and extension points.
- Resilient error handling.
- Avoidance of code duplication and design for extension to support similar cases.
- Abstracted logic using classes, functions, and variables.
- Fully automated solution without manual API calls for setting up entities.

Over-engineering to demonstrate knowledge is encouraged, within reason.

## Problems

### Problem #1: Matrix Generation
The application should interact with an API that provides endpoints for setting various types within the matrix.

#### API Endpoints

1. **Polyanets**
    - **Set Polyanet**
      ```http
      POST /api/polyanets
      {
          "row": "1", // int
          "column": "1" // int
      }
      ```
      **Response:** `{}`

    - **Delete Polyanet**
      ```http
      DELETE /api/polyanets
      {
          "row": "1", // int
          "column": "1" // int
      }
      ```
      **Response:** `{}`

2. **Soloons**
    - **Set Soloon**
      ```http
      POST /api/soloons
      {
          "row": "1", // int
          "column": "1", // int
          "color": "blue" // options: blue, red, purple, white
      }
      ```
      **Response:** `{}`

    - **Delete Soloon**
      ```http
      DELETE /api/soloons
      {
          "row": "1", // int
          "column": "1" // int
      }
      ```
      **Response:** `{}`

3. **Comeths**
    - **Set Cometh**
      ```http
      POST /api/comeths
      {
          "row": "1", // int
          "column": "1", // int
          "direction": "up" // options: up, down, right, left
      }
      ```
      **Response:** `{}`

    - **Delete Cometh**
      ```http
      DELETE /api/comeths
      {
          "row": "1", // int
          "column": "1" // int
      }
      ```
      **Response:** `{}`

4. **Goal**
    - **Get Final Matrix Goal**
      ```http
      POST /api/map/{map_id}/goal
      ```
      **Response:**
      ```json
      {
          "goal": [
              ["SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "POLYANET", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "POLYANET", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE"],
              ["SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE", "SPACE"]
          ]
      }
      ```

## Solution #1
- Use Retrofit to create endpoints with `http://challenge.crossmint.io/api/` as the base URL.
- Create entities for each data type (`Polyanet`, `Space`, `Cometh`, `Soloon`).
- Parse the goal response and map it to a matrix, where each JSON row equals a matrix row.

### Example Matrix
Replacing "SPACE" with `.` and "POLYANET" with `P`:

. . . . . . . . . . .
. . . . . . . . . . .
. . P . . . . . P . .
. . . P . . . P . . .
. . . . P . P . . . .
. . . . . P . . . . .
. . . . P . P . . . .
. . . P . . . P . . .
. . P . . . . . P . .
. . . . . . . . . . .
. . . . . . . . . . .


### Summary
To implement this solution with Clean Architecture principles:
1. Create a common repository for data types.
2. Define entities for each type (Polyanet, Space, etc.).
3. Automate the solution:
    - Parse the goal response, storing matrix indexes for each entity.
    - Flatten and filter the list, executing appropriate functions based on entity type.


