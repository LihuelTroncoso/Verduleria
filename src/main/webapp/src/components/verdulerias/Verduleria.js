import React from 'react'

const DEFAULT_IMAGE = ''

export const Verduleria = ({ description, image=DEFAULT_IMAGE }) => {
  return (
    <div>
        <img href={image}></img>
        {description}
    </div>
  )
}
