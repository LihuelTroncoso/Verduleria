import React from "react";
import { Image, Container } from "./styles";

const DEFAULT_IMAGE = 'https://i.imgur.com/jdPGGij.jpg'

export const Employee = ({photo = DEFAULT_IMAGE, name}) => {
    return (
        <Container>
            <Image src={photo} />
            <text>{name}</text>
        </Container>
    )
}