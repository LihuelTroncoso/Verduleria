import React from 'react'

const DEFAULT_IMAGE = ''

export const Product = ({ description, image=DEFAULT_IMAGE }) => {
  return (
    <div>
        <image href={image}></image>
        {description}
    </div>
  )
}
