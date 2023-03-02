import React from 'react'
import { Content, Links } from './styles'

const DEFAULT_ROUTE = 'AAA'
export const HeaderItem = ({ text, route=DEFAULT_ROUTE }) => {
  return (
    <Content><Links href={route}>{text}</Links></Content>
  )
}