import React from 'react'
import { Employee } from '../employees'
import { List, Item } from './styles'

export const ListOfEmployees = () => {
  return (
    <List>
      {
        [1, 2, 3, 4].map(employee => <Item key={employee}><Employee name="Oscar"/></Item>)
      }
    </List>
  )
}
