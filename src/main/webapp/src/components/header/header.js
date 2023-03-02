import React from 'react'
import { HeaderItem } from './headerItems/headerItem'
import { Logo } from '../logo/logo'
import { Container, Icon, List } from './styles'

export const Header = () => {
  return (
    <Container>
      <List>
        <HeaderItem text="Inicio"></HeaderItem>
        <HeaderItem text="Nuestros productos"></HeaderItem>
        <HeaderItem text="Empleados"></HeaderItem>
      </List>
      <Logo />
    </Container>
  )
}