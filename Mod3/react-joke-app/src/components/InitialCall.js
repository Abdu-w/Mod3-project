import React, { Component } from 'react';
import { v4 as uuid } from 'uuid';
import axios from 'axios';


export default class InitialCall extends Component {
  state = {
    isLoading: true,
    allJokes: [],
    joke: '',
    punchline: '',
    on:false,
  };

  async componentDidMount() {

    axios.get('https://official-joke-api.appspot.com/random_ten')
      .then(res => {
        const allJokes = res.data.map((jokesObj, idx) => {
          const jkContent = { // create record
            jk_id: idx,
            jk_type: jokesObj.type,
            jokes: jokesObj.setup,
            punch_line: jokesObj.punchline,
          }
          console.log( jkContent.jk_id, 'jhfjhoajnjvnajnejfnjnj')
          const test = {
            jk_id: 'idx',
            jk_type: 'jokesObj.type',
            jokes: 'jokesObj.setup',
            punch_line: 'jokesObj.punchline',

          }

          axios.post('first_api/v1/jokes', test) // post to DB
          return jkContent
        })

        this.setState({
          allJokes: allJokes,
        })
      })
  }


  onSubmit = (e) => {
    e.preventDefault()
    const joke = {
      jk_id: this.state.allJokes.length + 1,
      jk_type : 'add general', 
      jokes: this.state.joke,
      punch_line: this.state.punchline,
    }
    this.setState({
      joke: '',
      punchline: ''
    })
    axios.post('first_api/v1/jokes', joke) 
  }

  onChange = (e) => {
    this.setState({
      [e.target.name] : e.target.value
    })
  }

  editJoke = (id, punch_line) => {
    
    const  newJoke = prompt("update your joke");
    const  newpunchline = prompt("add a punchline");
    if(newJoke && newpunchline) {
      let  joke = {
        jk_id: id,
        jk_type : 'add general',
        jokes: newJoke,
        punch_line: newpunchline,
      }

      axios.put(`first_api/v1/jokes/${id}`,joke ) 
    }
  }

  removeJoke = (id) => {
    // console.log(id)
     axios.delete(`first_api/v1/jokes/${id}`)
  }

  revealPunchline =( id, punch_line) =>{
    this.setState({
      on:true,
      punchline:punch_line
    })
    if(this.state.on){
      this.setState({
        on: false,
        punchline: ''
      })
    }
   
  }


  render() {
    console.log(this.state)
  
    return (
      <div>

        <div className="initial">


        {
          this.state.allJokes.map(item =>
          <div className="joke-conatiner" key={item.jk_id}> 
            <p  className='jokes' 
                onClick={() => this.editJoke(item.id)} 
                onMouseOver={item.punch_line}>
              {item.jokes} 
            </p>
      
            <span>


              <div className = 'punch-line'>
              {this.state.on && !item.jk_id?this.state.punchline:null}
              </div>

              <button className='btn' onClick={() => this.removeJoke(item.jk_id)}>
              delete
              </button>


              <button
                key={item.jk_id} 
                className='punchline-btn'
                onClick={() => this.revealPunchline(item.jk_id, item.punch_line)}>
                punchline
              </button>

            </span>
            {/* <button className='punchLine-btn' onMouseOver */}
          </div>
          )
        }
      </div>
      <div className='form-container'>
        <div className='input-cont'>

          <form onSubmit={this.onSubmit}>
          <label className='label'>Add a joke</label>
            <input  
              className='input-joke'
              type='text' 
              name='joke' 
              value={this.state.joke} 
              placeholder="add a joke"
              onChange={this.onChange}
              />
            <input 
              className='input-joke'
              type='text' 
              name='punchline' 
              value={this.state.punchline} 
              placeholder="add a punchline"
              onChange={this.onChange}
              />
            <button className='btn'>add</button>
        </form>
        </div>
        
      </div>

    </div>
    );
  }
}
