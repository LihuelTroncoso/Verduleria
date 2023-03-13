import React from 'react'
import { useState, useEffect } from 'react'
import { List, Item } from './styles'
import { Verduleria } from '../verdulerias/Verduleria'
import Grid from '@mui/material/Grid'
import { getVerdulerias } from './api.js'

export const VerduleriasContainer = () => {
  const [verdulerias, setVerdulerias] = useState([]);

  useEffect(() => {
    const data = getVerdulerias()
    setVerdulerias(data)
  },[])

  return (
    <List>
      <Grid container spacing={{ xs: 2 }} >
        {Array.from(Array(6)).map((_, verduleria) => (
          <Grid item xs={2} md={4} key={verduleria}>
            <Verduleria description='HOLA'/>
          </Grid>
        ))}
      </Grid>
    </List>
  )
}