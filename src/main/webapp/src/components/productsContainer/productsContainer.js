import React from 'react'
import { List, Item } from './styles'
import { Product } from '../products/product'

export const ProductsContainer = () => {
  return (
    <List>
      {
        [1, 2, 3, 4, 5].map(product => <Item key={product}><Product description="VERDURA"/></Item>)
      }
    </List>
  )
}