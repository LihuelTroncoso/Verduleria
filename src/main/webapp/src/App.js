import React, { Fragment } from "react";
import { Header } from "./components/header/header";
import { GlobalStyle } from "./GlobalStyle"
import { ListOfEmployees } from "./components/listOfEmployees/listOfEmployees";
import { VerduleriasContainer } from "./components/verduleriasContainer/VerduleriasContainer";
export const App = () => {
    return <Fragment>
        <GlobalStyle />
        <Header />
        <VerduleriasContainer />
        <ListOfEmployees />
    </Fragment>
}