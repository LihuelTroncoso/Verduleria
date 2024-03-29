import styled from "styled-components";

export const List = styled.ul`
  display: flex;
  overflow: scroll;
  width: 100%;
  align-items: center;
  justify-content: center;
  &::-webkit-scrollbar {
    display: none;
  }
`
  

export const Item = styled.li`
  padding: 0 20px;
`