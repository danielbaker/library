var App = React.createClass({
	
	getInitialState: function() {
		return {
			active: 'people',
			people: null,
			books: null
		}
	},
	
	componentWillMount: function() {
		$.getJSON('/books', function(books) {
			this.state.books = books;
			this.setState(this.state);
		}.bind(this));
		
		$.getJSON('/people', function(people) {
			this.state.people = people;
			this.setState(this.state);
		}.bind(this));
	},
	
	onMenuSelect: function(e) {
		this.setState({
			active: e.target.innerText.toLowerCase()
		});
	},
	
	render: function() {
		return (	
			<div className="container">
				<div className="row">
					<div className="col-md-3">
						<SideMenu onMenuClick={this.onMenuSelect} activeMenu={this.state.active}/>
					</div>
					<div className="col-md-9">
						<PeopleList people={this.state.people} visible={this.state.active === 'people'}/>
						<BookList books={this.state.books} visible={this.state.active === 'books'}/>
					</div>
				</div>
			</div>
		);
	}
	
});

var SideMenu = React.createClass({
	
	render: function() {
		return (	
			<div className="list-group">
				<a 	href="#"
					className={this.props.activeMenu === 'people' ? "list-group-item active" : "list-group-item" }
					onClick={this.props.onMenuClick} >
					People
				</a>
				<a 	href="#"
					className={this.props.activeMenu === 'books' ? "list-group-item active" : "list-group-item" }
					onClick={this.props.onMenuClick} >
					Books
				</a>
			</div>
		);
	}
	
});

var PeopleList = React.createClass({
	
	render: function() {
		if (!this.props.visible) return null;
		
		if (!this.props.people) {
			return (
				<div className="panel panel-default">
					<div className="panel-body">
			  			Loading...
			  		</div>
		  		</div>
			);
		}
		
		var people = this.props.people.map(function(person) {
			return (
				<Person data={person} />
			);
		}.bind(this))
		
		return (
			<div className="panel panel-default">
			  	<div className="panel-heading">People</div>
			  	<div className="panel-body">
			  		The list of people who are registered with this library
		  		</div>

		  		<table className="table">
				    <tr>
				    	<th>Name</th>
				    	<th>Phone</th>
				    	<th>Email Address</th>
				    	<th>Borrowed Books</th>
				    </tr>
				    {people}
			    </table>
			</div>
		);
	}
	
});

var Person = React.createClass({
	
	getInitialState: function() {
		return {
			books: null
		}
	},
	
	onViewLentBooks: function() {
		if (this.state.books) {
			this.setState({
				books: null
			});
		} else {
			$.getJSON('/books/lentBy/' + this.props.data.id, function(books) {
				this.setState({
					books: books
				});
			}.bind(this))
		}
	},
	
	render: function() {
		var buttonText = this.state.books ? 'hide' : 'view';
		
		var person = (
			<tr>
		    	<td>{this.props.data.name}</td>
		    	<td>{this.props.data.phoneNumber}</td>
		    	<td>{this.props.data.emailAddress}</td>
		    	<td><button onClick={this.onViewLentBooks}>{buttonText}</button></td>
		    </tr>
		);
		
		var books = null;
		if (this.state.books) {
			books = (
				<tr>
					<td colSpan="4">
						<BookList books={this.state.books} visible={true} />
					</td>
				</tr>
			)
		}
		
		return (
			<tbody>
				{person}
				{books}
			</tbody>
		);
	}
	
});

var BookList = React.createClass({
	
	render: function() {
		if (!this.props.visible) return null;
		
		if (!this.props.books) {
			return (
				<div className="panel panel-default">
					<div className="panel-body">
			  			Loading...
			  		</div>
		  		</div>
			);
		}
		
		if (this.props.books.length == 0) {
			return (
				<div className="panel panel-default">
					<div className="panel-body">
			  			There are no books to display.
			  		</div>
		  		</div>
			);
		}
		
		var books = this.props.books.map(function(book) {
			return (
				<tr>
			    	<td>{book.title}</td>
			    	<td>{book.author}</td>
			    	<td>{book.isbn}</td>
			    </tr>
			);
		})
		
		return (
			<div className="panel panel-default">
			  	<div className="panel-heading">Books</div>
		  		<table className="table">
				    <tr>
				    	<th>Title</th>
				    	<th>Author</th>
				    	<th>ISBN</th>
				    </tr>
				    {books}
			    </table>
			</div>
		);
	}
	
});


React.render(<App />, document.getElementById('app'));