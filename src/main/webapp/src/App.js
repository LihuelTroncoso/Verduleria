import React, { Fragment } from "react";
import { Header } from "./components/header/header";
import { GlobalStyle } from "./GlobalStyle"
import { ListOfEmployees } from "./components/listOfEmployees/listOfEmployees";
import { ProductsContainer } from "./components/productsContainer/productsContainer";
export const App = () => {
    return <Fragment>
        <GlobalStyle />
        <Header />
        <ProductsContainer />
        <ListOfEmployees />
    </Fragment>
}